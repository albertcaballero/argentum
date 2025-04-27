const { contextBridge, ipcRenderer } = require('electron');

// Securely expose methods to renderer
contextBridge.exposeInMainWorld('electronAPI', {
  getRecurringExpenses: () => ipcRenderer.invoke('get-recurring-expenses')
});
