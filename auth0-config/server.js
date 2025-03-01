require('dotenv').config();
const express = require('express');
const cors = require('cors');
const { expressjwt: jwt } = require('express-jwt');
const jwks = require('jwks-rsa');

const app = express();
app.use(cors());
app.use(express.json());

// Middleware de autenticación
const checkJwt = jwt({
  secret: jwks.expressJwtSecret({
    cache: true,
    rateLimit: true,
    jwksUri: `https://${process.env.AUTH0_DOMAIN}/.well-known/jwks.json`
  }),
  audience: process.env.API_IDENTIFIER,
  issuer: `https://${process.env.AUTH0_DOMAIN}/`,
  algorithms: ['RS256']
});

// Ruta protegida
app.get('/private', checkJwt, (req, res) => {
  res.json({ message: 'Ruta protegida con Auth0', user: req.auth });
});

// Ruta pública
app.get('/public', (req, res) => {
  res.json({ message: 'Ruta pública, sin autenticación' });
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});