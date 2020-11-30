const mysql = require('mysql');

const conn = mysql.createConnection({
     host: '127.0.0.1',
     user: 'root',
     password: '123456',
     database: 'jogosdb'
    });

conn.connect(
    (err, args) => {
        if (err) { 
            console.log("Houve erro de conexão: ", err.sqlMessage);
        } else { 
            console.log("Conectado com sucesso");
        }
    }
);

function inserir_jogo() { 
    const jogo = {
        id: 1, 
        titulo: 'God Of War', 
        genero: 'acao', 
        plataforma: 'playstation', 
        qtd_jogadores: 1
    };
    conn.query('INSERT INTO jogos SET ?', jogo, (err)=>{
        if (err) { 
            console.log("Erro ao inserir no banco de dados: ", err.sqlMessage);
        } else { 
            console.log("Jogo inserido no banco de dados corretamente");
        }
    });
}

function consultar_jogos() { 
    conn.query('SELECT * FROM jogos', [], (err, result) => { 
        if (err) { 
            console.log("Não foi possível selecionar dados da tabela jogos: ", 
                err.sqlMessage);
        } else { 
            console.log("Dados da tabelas Jogos: ", result);
            result.forEach( (obj) => { 
                console.log(obj.id, " - ", obj.titulo);
            });
        }
    });
}

consultar_jogos();