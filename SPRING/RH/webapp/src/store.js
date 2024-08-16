import {configureStore} from "@reduxjs/toolkit";
import employers from "./stores/EmployerSlice.js"

export default configureStore({
    reducer: {
        employers :employers
    }
})