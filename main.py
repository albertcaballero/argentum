import sys
from PyQt5.QtWidgets import QApplication, QMainWindow
from PyQt5.uic import loadUi
from models import TableModel

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        loadUi("main_window.ui", self) 
        self.loadButtons()
        self.loadExpenseTable()
    
    def loadButtons(self):
    #    self.b_addExp.clicked.connect()
        self.b_deleteExp.clicked.connect(self.closeApp)

    def loadExpenseTable(self):
        data = [
          [4, 9, 2],
          [1, 0, 0],
          [3, 5, 0],
          [3, 3, 2],
          [7, 8, 9],
        ]

        self.model = TableModel(data)
        self.tb_RecurringExpense.setModel(self.model)

    def closeApp(self):
        sys.exit(app.exec_())

app = QApplication(sys.argv)
window = MainWindow()
window.show()
sys.exit(app.exec_())

