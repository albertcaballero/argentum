
function loadExpenses(expenses){
    const expensesTableBody = document.getElementById('recurringExpensesBody');
    expensesTableBody.innerHTML = ''; // Clear previous entries
    expenses.forEach(expense => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${expense.id}</td>
        <td>${expense.concept}</td>
        <td>${expense.sender}</td>
        <td>${expense.receiver}</td>
        <td>${expense.amount}</td>
        <td>${expense.amountYear}</td>
        <td>${expense.date}</td>
      `;
      expensesTableBody.appendChild(row);
    });
}


window.addEventListener('DOMContentLoaded', async () => {
   //loading from DB 
    const expenses = await window.electronAPI.getRecurringExpenses();
    loadExpenses(expenses);


    // Adding click to rows
    const rows = document.querySelectorAll('tr');
    rows.forEach((row) => {
       row.addEventListener('click', () => {
            row.classList.toggle('selected');
       }); 
    });
});
