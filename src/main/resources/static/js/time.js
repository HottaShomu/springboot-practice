document.addEventListener('DOMContentLoaded', function() {
    const deadlineElements = document.querySelectorAll('td:nth-child(3) > span');
    const currentDate = new Date();

    deadlineElements.forEach(function(deadlineElement) {
        const deadlineString = deadlineElement.innerText;
        const deadlineDate = new Date(deadlineString);

        // 締切が1日後に迫っている場合は赤にする、締め切りが黄色は10日後
        if ((deadlineDate - currentDate) / (1000 * 60 * 60 * 24) <= 1) {
            deadlineElement.style.color = 'red';
        }else if((deadlineDate - currentDate) / (1000 * 60 * 60 * 24) <= 9){
            deadlineElement.style.color = '#FFD700'
        }
    });
});