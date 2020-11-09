const http = require('http');
const fs = require('fs').promises;

const port = 80;
const host = 'localhost';

const responder = (requisicao, resposta) => { 
    console.log(`Lendo arquivo: ${__dirname}${requisicao.url}`);
    resposta.setHeader("Content-Type", "text/html");
    resposta.writeHead(200);
    fs.readFile(__dirname + requisicao.url)
    .then( (texto) => {
        resposta.end(texto);
    });
}

const server = http.createServer(responder);
server.listen(port, host, () => {
    console.log(`Servidor http://${host}:${port} esta iniciado`);
});