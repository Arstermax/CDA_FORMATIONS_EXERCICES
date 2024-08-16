import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from "axios";


const url = "http://localhost:8080/Employer/";
export const fetchEmployers = createAsyncThunk(
    "employers/fetchEmployers",
    async () => {
        const response = await axios.get(url);
        const data = await response.data;
        return data
    }
)


const employersSlice = createSlice({
    name: "employers",
    initialState: {
        data: []
    },
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(fetchEmployers.fulfilled, (state, action) => {
            state.data = action.payload;
        })
    }
})

export default employersSlice.reducer;