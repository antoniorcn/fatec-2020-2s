const http = require("http");
const host = 'localhost';
const port = 80;

function responder(requisicao, resposta) { 
    resposta.end("<h1>Ola mundo navegador</h1>");
}

const servidor=http.createServer(responder);
servidor.listen(port, host, () => {
    console.log("Servidor iniciado");
})

// function rodarServidor() { 
//     console.log("Servidor iniciado");
// }
// servidor.listen(port, host, rodarServidor);
