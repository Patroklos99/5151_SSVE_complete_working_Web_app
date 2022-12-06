import React, {useState} from 'react';
import TripService from '../../services/tripServices';
import TimelineNeedsState from '../../types/timelineNeeds';
import "./timeline.css";

function App() {
  
  const[needsState, setNeedsState] = React.useState<TimelineNeedsState>()
  const [timelineFile, setTimelineFile] = useState<string>("")

  function handleNeedsChange(event: { target: { value: any; name: any; }; }){
    const value = event.target.value;
    setNeedsState({
      ...needsState,
      [event.target.name]: value
    });
   console.log(needsState);
  }

  function formSubmit(e: any) {
    e.preventDefault();
    TripService.postTimelineNeeds(needsState!)

    TripService.postTimelineTrips(timelineFile).then((response: any) => {
      console.log(response.data);
    }).catch((e: Error) => {
      console.log(e);
    });
  }

  function handleTimeline(files: FileList|null) {
    if (files) {
      const fileRef = files[0] || ""
      const fileType: string= fileRef.type || ""
          if (fileType != "application/json") {
            alert("Téléverser un fichier de type .JSON")
            return;
            }
      const reader = new FileReader()
      reader.readAsBinaryString(fileRef)
      reader.onload=(ev: any) => {
        setTimelineFile(ev.target.result)
      }
    }
  }
  return (
    <div className="App">
      <header className="App-header">
      <div className="form-style-3" >
        Entréz vos besoins et téléversez votre fichier Google Timeline (.json)
        <br></br>
        <br></br>
        <fieldset>
        <form>

          <label> <span> Autonomie désiré: </span>
            <input
              type="number"
              name="autonomy"
              value={needsState?.autonomy}
              onChange={handleNeedsChange}
            />
            </label>
            <br></br>
            <label> <span> Temps de recharge désiré: </span>
            <input
              type="number"
              name="chargeTime"
              value={needsState?.chargeTime}
              onChange={handleNeedsChange}
            />
            </label>

          </form>
          </fieldset>

          <div className="choose-btn">
        <form  onSubmit={formSubmit} >
            <input type="file" onChange={(e)=> handleTimeline(e.target.files)}/>
          { timelineFile &&
            <>
            <hr/>
            <button> Téléverser </button>
            </>
          }


        </form>
</div>

        </div>
      </header>
    </div>
  );
}
export default App;  


