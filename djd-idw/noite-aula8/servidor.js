const http = require("http");
const fs = require('fs').promises;

const porta = 10500;
const host = 'localhost';

// function pedido(requisicao, resposta) { 
//     resposta.setHeader("Content-Type", "text/html");
//     resposta.writeHead(200);
//     resposta.end("<h1>Ola Navegador</h1>");
// }


function pedidoArquivo(requisicao, resposta) { 
    fs.readFile(__dirname + requisicao.url).then(
        (conteudo) => { 
            resposta.setHeader("Contente-Type", "text/html");
            resposta.writeHead(200);
            resposta.end(conteudo);
        }
    );
}

function iniciaServidor() { 
    console.log(`Servidor iniciado na porta: http://${host}:${porta}`);
}

const servidor = http.createServer(pedidoArquivo);

servidor.listen(porta, host, iniciaServidor);