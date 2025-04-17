from PyQt5 import QtCore
from PyQt5.QtCore import Qt

# https://www.pythonguis.com/tutorials/qtableview-modelviews-numpy-pandas/
class TableModel(QtCore.QAbstractTableModel):
    def __init__(self, data):
        super().__init__()
        self.data = data

    def data(self, index,role):
        if role == Qt.DisplayRole:
            return self.data[index.row()][index.column()]
    
    def rowCount(self, index):
        return len(self.data)

    def columnCount(self, index):
        return len(self.data[0])



class Fund():
    def __init__(self, name, amount=0.0):
        self.table_database = 'public.funds'
        self.name = name
        self.amount = amount
