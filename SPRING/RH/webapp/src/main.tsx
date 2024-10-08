import React from 'react'
import ReactDOM from 'react-dom/client'
import {router} from './routes.jsx'
import './index.css'
import store from "./store.js"
import {RouterProvider} from "react-router-dom";
import {Provider} from "react-redux";

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <Provider store={store}>
            <RouterProvider router={router}/>
        </Provider>
    </React.StrictMode>,
)
