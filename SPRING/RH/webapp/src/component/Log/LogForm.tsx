interface LogFormProps {
    width: string;
    title: string;
    height: string;
}

function LogForm({width, title, height}: LogFormProps) {

    return (
        <form
            className={`${width} ${height} relative flex flex-col gap-10 pt-20 p-16 pl-32 pr-32 items-center justify-center border-2`}>
            <hgroup
                className={" absolute top-[-35px] right-50 bg-blue-700 w-80 rounded-lg text-center text-white m-3 p-2"}>
                <h1 className={"text-4xl p-2"}>{title}</h1>
            </hgroup>
            <fieldset className={"w-full flex flex-col justify-center items-start"}>
                <label className={"text-2xl "} htmlFor="">Username</label>
                <input type="text" placeholder={"JohnDoe@mail.com"}
                       className={"w-full border-b-2 p-2 outline-blue-400"}/>
            </fieldset>
            <fieldset className={"w-full flex flex-col justify-center items-start"}>
                <label className={"text-2xl active:border-blue-400"} htmlFor="">Password </label>
                <input type="text" placeholder={"************"} className={"w-full border-b-2 p-2 outline-blue-400"}/>
            </fieldset>

            <input type={"submit"} value={title}
                   className={"relative  border-2 bg-blue-700 text-white p-3 pr-20 pl-20 rounded-lg cursor-pointer  hover:bottom-[1px] hover:bg-blue-600 active:bottom-[-1px] active:bg-blue-800"}/>
        </form>
    );
}

export default LogForm;