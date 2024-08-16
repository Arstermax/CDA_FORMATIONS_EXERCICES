import {NavigateFunction, useNavigate} from "react-router-dom";
import {UserIcon} from "@heroicons/react/20/solid";

function Header(props) {

    const navigate = useNavigate();

    return (
        <header className={"bg-blue-700 flex items-center h-[10vh] pr-24 pl-24  justify-between"}>
            <nav className={"w-2/12  items-center text-center gap-6 flex  list-none text-white "}>
                <li className={"cursor-pointer hover:text-gray-300"} onClick={() => navigate("/")}>RH_Applications</li>
            </nav>
            <nav className={"w-5/6 justify-around flex"}>
            </nav>
            <nav className={"w-1/12 list-none text-white"}>
                <li className={"cursor-pointer hover:text-gray-300"} onClick={() => navigate("/dashboard")}><UserIcon
                    className={"w-10 border-2 rounded-full"}/></li>
            </nav>
        </header>
    );
}

export default Header;