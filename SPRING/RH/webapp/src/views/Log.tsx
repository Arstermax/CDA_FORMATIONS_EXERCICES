import LogForm from "../component/Log/LogForm.tsx";

function Log() {
    return (
        <main className={"flex justify-center items-center"}>
            <LogForm width={"w-[40rem]"} height={"h-[25rem]"} title={"Log In"} />
        </main>
    );
}

export default Log;