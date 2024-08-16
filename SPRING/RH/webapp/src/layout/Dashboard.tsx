import {useNavigate} from "react-router-dom";
import {BeakerIcon, ChevronDoubleLeftIcon, ChevronDoubleRightIcon} from "@heroicons/react/16/solid";
import {UserGroupIcon} from "@heroicons/react/16/solid";
import {UserIcon} from "@heroicons/react/20/solid";
import {useState} from "react";

function Dashboard() {

    const navigate = useNavigate();


    const [isActive, setIsActive] = useState<boolean>(true)


    return (
        <header className={`flex-col ${(isActive) ? "w-1.5/12" : "w-0.5/12"} flex p-2 absolute  items-center  bg-blue-900 h-[90vh]`}>
            <figure className={"w-full h-30 relative flex justify-center items-center'"}>
                {(isActive) &&
                    <UserIcon className={"border-[1px] m-10 text-white w-24 h-24 rounded-full"}/>
                }
                {(isActive) ?
                    <ChevronDoubleLeftIcon onClick={() => setIsActive(!isActive)}
                                           className={"absolute border-black right-0 top-0 w-10 -[.5px] border-2 cursor-pointer"}/>
                    :
                    <ChevronDoubleRightIcon onClick={() => setIsActive(!isActive)}
                                            className={"absolute border-black right-50 top-0 w-10 -[.5px] border-2 cursor-pointer"}/>
                }
            </figure>
            {(isActive) &&
                <article className={"mt-5 mb-5 border-b-2 border-t-2 p-1 w-full flex justify-center items-center"}>
                    <p className={"text-2xl"}>Nom Prenom</p>
                </article>
            }
            <nav className={`w-full flex flex-col gap-3 ${(!isActive)&&"pt-12"}`}>
                <li className={"flex justify-center items-center cursor-pointer hover:text-gray-200  text-2xl"}
                    onClick={() => navigate("/dashboard")}><UserGroupIcon className={"w-8"}/> {(isActive) && "Employer"}
                </li>
                <li className={"flex justify-center items-center cursor-pointer hover:text-gray-200  text-2xl"}
                    onClick={() => navigate("/dashboard")}><BeakerIcon className={"w-8"}/> {(isActive) && "Candidats"}
                </li>
            </nav>
        </header>
    );
}

export default Dashboard;