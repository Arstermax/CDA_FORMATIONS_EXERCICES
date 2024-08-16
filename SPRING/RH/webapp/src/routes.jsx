import {createBrowserRouter} from "react-router-dom";
import Layout from "./layout/Layout.tsx";
import Home from "./views/Home.tsx";
import LayoutDashboard from "./layout/LayoutDashboard.tsx";
import Log from "./views/Log.tsx";
import HomeDashBoard from "./views/HomeDashBoard.tsx";
import EmployerDashboard from "./views/EmployerDashboard.tsx";



export  const  router = createBrowserRouter([
    {
        path : "/",
        element : <Layout />,
        children : [
            {
                path : "/",
                element : <Home />
            },
            {
                path :"/logIn",
                element : <Log />
            }
        ]
    },
    {
        path :"/dashboard",
        element : <LayoutDashboard />,
        children : [
            {
                path : "/dashboard/",
                element : <HomeDashBoard />
            },
            {
                path : "/dashboard/Employer",
                element : <EmployerDashboard />
            }
        ]
    }
])

