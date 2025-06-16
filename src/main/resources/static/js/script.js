let isAscending =true; //初期状態は昇順
function sortTable(columnIndex) {
    const table = document.querySelector('table');
    const tbody = table.querySelector('tbody');
    const rows = Array.from(tbody.querySelectorAll('tr'));

    rows.sort((a, b) => {
        //cells[columIndex]は列を指定
        let aText = a.cells[columnIndex].textContent;
        let bText = b.cells[columnIndex].textContent;

        let aDate = new Date(aText);
        let bDate = new Date(bText);
        
        //trueだったら昇順、falseだったら降順
        if (isAscending) {
            return aDate - bDate;
        } else {
            return bDate - aDate;
        }
    });
    rows.forEach(row => tbody.appendChild(row));
    isAscending = !isAscending;
}