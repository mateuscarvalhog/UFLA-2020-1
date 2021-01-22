### MATEUS CARVALHO GONCALVES - 201810245
### OTAVIO AUGUSTO DE SOUSA RESENDE - 201810543

import socket 
import select
import sys

# informacoes de ip e porta do servidor
host = '127.0.0.1'
port = 8001

# cria socket tcp e abre conexao com servidor
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.connect((host, port))

# mensagem de boas vindas do servidor e coleta de identificador
print(server.recv(2048).decode())
name = input("Como gostaria de ser identificado no chat? ")
server.send(name.encode())

# \n apenas para estética
print()

in_chat = True  
if not name or name == 'sair' or name == 'SAIR' or name == 'Sair':
    in_chat = False

while in_chat:
    try:
        # possiveis inputs: terminal do cliente ou servidor
        sockets_list = [sys.stdin, server] 
    
        # select permite conexao assincrona
        # duas opcoes: enviar para servidor / receber mensagem do servidor
        read_sockets,write_socket, error_socket = select.select(sockets_list,[],[]) 
    
        for one_socket in read_sockets: 
            if one_socket == server:
                # printa mensagem recebida
                message = one_socket.recv(2048) 
                print (message.decode()) 
            else: 
                message = sys.stdin.readline() 
                if  message == "sair\n" or message == "SAIR\n" or message == "Sair\n": 
                    # envia mensagem para desconectar
                    print("Voce saiu\n")
                    server.send(message.encode())
                    in_chat = False
                elif message:
                    server.send(message.encode()) 
                    
                    sys.stdout.write("Voce: " + message + "\n") 
                    sys.stdout.flush()
    except:
        # excecao envia mensagem para desconectar do servidor e desconecta cliente
        server.send("sair\n".encode())
        in_chat = False

        print("\nVoce saiu\n")

server.close()