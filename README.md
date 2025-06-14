requisiçoes que podem ser feitas, user rodando mas só fiz integracao entre sala e reserva:

Listar todas as salas
GET http://localhost/api/sala

Criar nova sala
POST http://localhost/api/sala
Content-Type: application/json
ex.
{
    "nome": "Sala 101",
    "capacidade": 30
}


Reservar sala
POST http://localhost/api/sala/{id}/reservar
Content-Type: application/json

"2025-12-31T14:00:00"


Listar todas as reservas
GET http://localhost/api/reserva