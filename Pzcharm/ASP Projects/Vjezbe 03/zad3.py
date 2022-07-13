class Person(object):
    def __init__(self, firstname, lastname):
        self._firstname = firstname
        self._lastname = lastname

class User(Person):
    def __init__(self, username, password, firstname, lastname):
        super().__init__(self, firstname, lastname)
        self._username = username
        self._password = password
        self._function = "Client"

class RegisteredClient(User):
    def __init__(self, username, password, firstname, lastname, phone, email, pole):
        super().__init__(username, password, firstname, lastname)
        self._phone = phone
        self._email = email
        self._pole = pole

class Beautician(RegisteredClient):
    def __init__(self, username, password, firstname, lastname, function, phone, email, pole, service):
        super().__init__(self, username, password, firstname, lastname, function, phone, email, pole)
        self._service = service

class Manager(RegisteredClient):
    def __init__(self, username, password, firstname, lastname, function, phone, email, pole):
        super().__init__(self, username, password, firstname, lastname, function, phone, email, pole)
        self._subordinates
