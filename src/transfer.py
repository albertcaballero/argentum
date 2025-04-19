



class Transfer():
	def __init__(self, id, sender, reciever, amount, description, date):
		self.id = id
		self.sender=sender
		self.reciever=reciever
		self.amount=amount
		self.concept = description
		self.date = date
	
	def toList(self):
		return [self.sender, self.reciever, self.amount, self.concept, self.date]



class TransferDAO():
	def __init__(self, conn):
		self.table_database = 'transfers'
		self.conn = conn

	def get_all(self):
		cursor = self.conn.cursor()
		cursor.execute("SELECT * FROM "+ self.table_database)
		rows = cursor.fetchall()
		return [
			Transfer(id, from_acc, to_acc, amt, date, concept)
			for id_, from_acc, to_acc, amt, date,concept in rows
		]
		
	def get_all_array(self):
		transfers = self.get_all()
		return [
			t.toList() for t in transfers
		]
		

	def insert(self, transfer):
		pass

	def update(self, transfer):
		pass

	def delete(self, transfer_id):
		pass
