
function loadExpenses(expenses){
    const expensesTableBody = document.getElementById('recurringExpensesBody');
    expensesTableBody.innerHTML = ''; // Clear previous entries
    let totalM = 0;
    let totalY = 0;
    expenses.forEach(expense => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${expense.id}</td>
        <td>${expense.concept}</td>
        <td>${expense.sender}</td>
        <td>${expense.receiver}</td>
        <td>${expense.amountMonth}</td>
        <td>${expense.amountYear}</td>
        <td>${expense.date}</td>
      `;
      expensesTableBody.appendChild(row);
       row.addEventListener('click', () => {
            row.classList.toggle('selected');
       }); 
        totalM += expenses.amountMonth;
        totalY += expense.amountYear;
    });
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>Total</td> <td></td> <td></td> <td></td>
        <td>${totalM}</td>
        <td>${totalY}</td>
        <td></td>`;
    row.style.borderTop = '3px solid black';
    expensesTableBody.appendChild(row);
}


window.addEventListener('DOMContentLoaded', async () => {
   //loading from DB 
    const expenses = await window.electronAPI.getRecurringExpenses();
    loadExpenses(expenses);
});

