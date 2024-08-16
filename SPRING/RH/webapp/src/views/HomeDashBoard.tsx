import HeaderDashboardView from "../layout/HeaderDashboardView.tsx";

function HomeDashBoard() {


    return (
        <main className={`bg-blue-50 pl-52 pr-10 w-full `}>
            <HeaderDashboardView title={"Welcommes [Nom prénom]"} />
        </main>
    );
}

export default HomeDashBoard;