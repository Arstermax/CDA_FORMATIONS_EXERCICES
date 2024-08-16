import HeaderDashboardView from "../layout/HeaderDashboardView.tsx";
import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import {fetchEmployers} from "../stores/EmployerSlice";
import TableCompenents from "../component/employers/TableCompenents.tsx";


function EmployerDashboard() {

    const dispatch = useDispatch();
    const employer = useSelector(state => state.employers.data)

    useEffect(() => {
        dispatch(fetchEmployers())
    }, []);

    console.log(employer)


    return (
        <main className={`bg-blue-50 pl-52 pr-10 w-full `}>
            <HeaderDashboardView title={"Employer"}/>
            <section className={"p-6 w-6/12"}>
               <TableCompenents datas={employer} />
            </section>
        </main>
    );
}

export default EmployerDashboard;