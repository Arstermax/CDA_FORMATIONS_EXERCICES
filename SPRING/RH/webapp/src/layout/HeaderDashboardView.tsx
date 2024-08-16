import {PlusCircleIcon} from "@heroicons/react/16/solid";


function HeaderDashboardView({title}) {
    return (
        <>
            <header className={" w-full relative h-48 flex justify-between items-center  "}>
                <hgroup>
                    <h1 className={"text-3xl  p-6 m-6 text-blue-900 "}>{title}</h1>
                </hgroup>
                <PlusCircleIcon
                    className={"w-16 m-6 text-blue-700 cursor-pointer hover:text-blue-800 active:text-blue-600"}/>
            </header>
            <hr className={"p-[.3px] bg-blue-700 w-full"}/>
        </>
    );
}

export default HeaderDashboardView;