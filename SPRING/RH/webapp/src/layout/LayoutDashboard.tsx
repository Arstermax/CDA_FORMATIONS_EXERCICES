import Dashboard from "./Dashboard.tsx";
import Header from "./Header.tsx";
import {Outlet} from "react-router-dom";
import {useState} from "react";

function LayoutDashboard() {

    const [isActive, setIsActive] = useState(false)

    return (
        <>
            <Header/>
            <div className={"flex relative"}>
                <Dashboard/>
                <Outlet/>
            </div>
        </>
    );
}

export default LayoutDashboard;