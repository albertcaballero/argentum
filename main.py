import sys
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5.uic import loadUi
from src import models, transfer
import sqlite3 as sql


def DUMMYaddExpense(conn):
	cursor = conn.cursor()
	cursor.execute("INSERT INTO transfers (sender, reciever, amount, date) VALUES ('yo', 'tu', 100.23, '2025-04-18')")
	conn.commit()
	

class MainWindow(QMainWindow):
	def __init__(self):
		super().__init__()
		loadUi("main_window.ui", self) 
		self.conn = sql.connect('argentum.db')
		self.loadButtons()
		self.loadExpenseTable()
	
	def loadButtons(self):
		self.b_addExp.clicked.connect(lambda: DUMMYaddExpense(self.conn))
		self.b_deleteExp.clicked.connect(self.closeApp)

	def loadExpenseTable(self):
		transfers = transfer.TransferDAO(self.conn)
		self.model = models.TableModel(transfers.get_all_array())
		self.tb_RecurringExpense.setModel(self.model)

	def closeApp(self):
		self.conn.close()
		sys.exit(app.exec_())

app = QApplication(sys.argv)
window = MainWindow()
window.show()
sys.exit(app.exec_())

