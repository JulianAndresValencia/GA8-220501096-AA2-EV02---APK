const express = require('express');
const mongoose = require('mongoose');

const app = express();
const port = 3000; // Puerto en el que el servidor escuchará las solicitudes

// Middleware para parsear JSON
app.use(express.json());

// Conectar a MongoDB (reemplaza 'mongodb://localhost:27017/user_management' con tu URI)
mongoose.connect('mongodb://localhost:27017/user_management', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
});

// Verificar conexión
mongoose.connection.on('connected', () => {
  console.log('Conectado a MongoDB');
});

// Ruta básica
app.get('/', (req, res) => {
  res.send('¡Hola Mundo!');
});

// Iniciar el servidor
app.listen(port, () => {
  console.log(`Servidor corriendo en http://localhost:${port}`);
});
