let isAscending =true; //初期状態は昇順
let isAscending2 = true; //初期状態は昇順
function sortTable(columIndex) {
    const table = document.querySelector('table');
    const tbody = table.querySelector('tbody');
    const rows = Array.from(tbody.querySelectorAll('tr'));

    rows.sort((a, b) => {
        //cells[columIndex]は列を指定
        let aText = a.cells[columIndex].textContent;
        let bText = b.cells[columIndex].textContent;

        let aDate = new Date(aText);
        let bDate = new Date(bText);
        
        if(columIndex === 0){
            const priorityMap ={
                "高":3,
                "中":2,
                "低":1,
            };

            //高、中、小が無かったら0を代入
            let aPriority;
            if (priorityMap[aText] !== undefined) {
                aPriority = priorityMap[aText];
            } else {
                aPriority = 0;
            }

            let bPriority;
            if (priorityMap[bText] !== undefined) {
                bPriority = priorityMap[bText];
            }else{
                bPriority = 0;
            }
            //trueだったら昇順、falseだったら降順
            if (isAscending2) {
                return aPriority - bPriority;
            } else {
                return bPriority - aPriority;
            } 
        }else{
            //trueだったら昇順、falseだったら降順
            if (isAscending) {
                return aDate - bDate;
            } else {
                return bDate - aDate;
            } 
        }

    });
    rows.forEach(row => tbody.appendChild(row));
    if (columIndex === 0) {
        isAscending2 = !isAscending2;
    } else {
        isAscending = !isAscending;
    }
}