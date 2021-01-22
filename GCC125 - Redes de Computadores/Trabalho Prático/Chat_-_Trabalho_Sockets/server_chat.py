### MATEUS CARVALHO GONCALVES - 201810245
### OTAVIO AUGUSTO DE SOUSA RESENDE - 201810543

import socket 
from _thread import *

#informacoes de ip e porta do servidor
host = ''
port = 8001

#criando socket tcp e definindo capacidade maxima
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server.bind((host, port))
server.listen(5)

#lista de clientes conectados no servidor
list_of_clients = [] 

print("Servidor iniciado!\n")

#funcao que atende (um) cliente enquanto esta conectado na nova thread criada
def client_thread(conn, addr): 
  
    # mensagem de boas vindas
    conn.send("Bem vindo a sala de chat!\n".encode())

    # coleta identificador do cliente
    name = conn.recv(2048).decode()

    # verifica se nome eh valido e anuncia para todos que a pessoa entrou
    if not name or name == 'sair' or name == 'SAIR' or name == 'Sair':
        remove(conn) 
        return False
    else:
        broadcast(name + " conectou!\n", conn)
        print(name + " conectou!\n")             


    while True: 
        try:
            message = conn.recv(2048).decode()
            
            # verifica se mensagem eh valida
            if  message == "sair\n" or message == "SAIR\n" or message == "Sair\n": 
                #faz broadcast da saida e remove conexao
                broadcast(name + " saiu\n", conn)
                print(name + " saiu\n")
                remove(conn)
                return False
            else:
                
                # prepara mensagem com nome e chama broadcast() para enviar para todos
                message_to_send = name + ": " + message
                print(message_to_send)
                broadcast(message_to_send, conn)
        except:
            #fecha conexao se der erro
            return False

# faz broadcast de mensagem
# manda para todos os clientes conectados exceto o remetente
def broadcast(message, connection): 
    for client in list_of_clients: 
        if client != connection: 
            try:
                client.send(message.encode()) 
            except:
                #fecha a conexao quebrada e remove da lista
                client.close()
                remove(client)

#remove a conexao fechada da lista
def remove(connection): 
    try:
        if connection in list_of_clients: 
            list_of_clients.remove(connection)
    except:
        print("Erro: conexao nao conhecida\n")

while True:

    #aceita requisicao de conexao
    #conn guarda o objeto socket e addr o ip do cliente
    conn, addr = server.accept() 
  
    #adiciona novo cliente na lista
    list_of_clients.append(conn)
  
    #cria nova thread para atender o novo cliente
    #executa funcao client_thread
    start_new_thread(client_thread, (conn,addr)) 

conn.close()
server.close()