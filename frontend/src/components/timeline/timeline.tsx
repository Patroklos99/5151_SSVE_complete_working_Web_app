import React, {useState} from 'react';
import TripService from '../../services/tripServices';
import TimelineNeedsState from '../../types/timelineNeeds';
import "./timeline.css";

function App() {

  const [timelineFile, setTimelineFile] = useState<string>("")

  function formSubmit(e: any) {
    e.preventDefault();
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
      <fieldset  className="form-input">

        Téléversez votre fichier Google Timeline (.json)
        <br></br>
        <br></br>
          <div>
            <form  onSubmit={formSubmit} >
            <input type="file" onChange={(e)=> handleTimeline(e.target.files)}/>
          { timelineFile &&
            <>
            <hr/>
            <button> <span> Téléverser </span>  </button>
            </>
          }
            </form>
           </div>
        </fieldset>
            </div>
      </header>
    </div>

  );
}
export default App;  


