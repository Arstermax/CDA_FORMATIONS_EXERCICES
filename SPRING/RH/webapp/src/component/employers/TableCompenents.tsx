import ThComponents from "./ThComponents.tsx";

function TableCompenents({datas}) {

    const taille = {
        minWidth: "120px",
        maxWidth: "220px",
        thColors: "bg-blue-700",
        textColor: "text-white"
    }

    return (
        <table className={"border-collapse border border-slate-500"}>
            <thead>
            <tr>
                <ThComponents type={"head"} title={"Nom"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Email"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"IdNumber"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Adresse"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"N°Phone"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"BirthDate"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Date Debut"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Date Fin"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Poste"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Role"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Salaire"} colors={taille.thColors} textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
                <ThComponents type={"head"} title={"Observations"} colors={taille.thColors}
                              textColors={taille.textColor}
                              wMax={taille.maxWidth} wMin={taille.minWidth}/>
            </tr>
            </thead>
            <tbody>

            {datas.map((data, key) => (
                <tr className={"flex justify-evenly"} key={key}>
                    <ThComponents title={data.name} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.email} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.identificationNumber} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.adresse} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.phone} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.birthDate} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.contractStart} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.contractEnd} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.occupation} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={(data.admin) ? "admin" : "user"} vMax={taille.maxWidth}
                                  wMin={taille.minWidth}/>
                    <ThComponents title={data.salary} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                    <ThComponents title={data.observation} vMax={taille.maxWidth} wMin={taille.minWidth}/>
                </tr>
            ))}
            </tbody>
        </table>
    )
        ;
}

export default TableCompenents;