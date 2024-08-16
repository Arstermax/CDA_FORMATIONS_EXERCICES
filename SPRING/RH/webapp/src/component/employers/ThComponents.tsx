function ThComponents({title, wMin, wMax, colors, textColors, type}) {
    return (
        (type === "head") ?

            <th className={`border border-slate-500 min-w-[${wMin}]  max-w-[${wMax}] border-blue-950 ${colors} ${textColors} p-2`}>
                <p>
                    {title}
                </p>
            </th>
            :
            <td className={`border border-slate-500  min-w-[${wMin}]  max-w-[${wMax}]`}>
                <p>
                    {title}
                </p>
            </td>
    )
}

export default ThComponents;