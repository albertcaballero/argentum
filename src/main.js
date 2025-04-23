const { app, BrowserWindow, ipcMain } = require('electron');
const path = require('path');

// Mock database function
const getUsers = () => {
  return [{ id: 1, name: "Alice" }, { id: 2, name: "Bob" }];
};

function createWindow () {
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      preload: path.join(__dirname, 'preload.js'),
    }
  });

  win.loadFile('src/index.html');
}

// Handle IPC request from renderer
ipcMain.handle('get-users', async () => {
  return getUsers(); // Could be real DB logic
});

app.whenReady().then(createWindow);
