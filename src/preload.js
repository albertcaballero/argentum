const { contextBridge, ipcRenderer } = require('electron');

// Securely expose methods to renderer
contextBridge.exposeInMainWorld('electronAPI', {
  getUserList: () => ipcRenderer.invoke('get-users')
});
