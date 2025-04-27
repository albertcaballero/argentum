const { app, BrowserWindow, ipcMain } = require('electron');
const path = require('path');
const {win32} = require('path/posix');
const sqlite = require('sqlite3').verbose();

const db = new sqlite.Database('argentum.db');

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
ipcMain.handle('get-recurring-expenses', async () => {
    return new Promise((resolve, reject) => {
    const query = `SELECT *  FROM transfers`;
    db.all(query, [], (err, rows) => {
      if (err) {
        console.error('Database error:', err.message);
        reject(err);
      } else {
        resolve(rows);
      }
    });
  });
});

app.whenReady().then(createWindow);


app.on('window-all-closed', () => {
  if (db) {
    db.close((err) => {
      if (err) {
        console.error('Error closing database:', err.message);
      } else {
        console.log('Database connection closed.');
      }
    });
  }
});
