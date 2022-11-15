import { rest } from 'msw';
export const handlers = [
    // Handles a POST /vehicle request
    rest.post('http://localhost:8080/api/vehicule', (req, res, ctx) => {
        
        return res(
            // The status of our response
            ctx.status(200),
        )
    }),

    // Handles a GET /vehicle request
    rest.get('/http://localhost:8080/api/vehicule', (req, res, ctx) => {

        const { carId } = req.params

        if(carId != "1"){
            // Here we mock a 404 to simulate a bad Get request
            return res(
                ctx.status(404),
                ctx.json({
                    errorMessage: 'Not found',
                })
            )
        } else {
            // Here we mock the real Get request response
            ctx.status(200),
            ctx.json({
                id: 1,
                modelName: "lamborghini",
            })
        }
    }),
]