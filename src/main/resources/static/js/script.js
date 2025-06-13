function sortTable(columnIndex) {
    const table = document.querySelector("table");
    const rows = Array.from(table.rows).slice(1);
    const isAscending = table.querySelectorAll("th")[columnIndex].classList.toggle("asc");

    rows.sort((a, b) => {
        const aText = a.cells[columnIndex].innerText.trim();
        const bText = b.cells[columnIndex].innerText.trim();

        return isAscending
            ? aText.localeCompare(bText, 'ja')
            : bText.localeCompare(aText, 'ja');
    });

    rows.forEach(row => table.tBodies[0].appendChild(row));
}