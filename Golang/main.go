package main

import (
	"net"
	"strconv"
	"bufio"
	"fmt"
	"strings"
)

func main() {
	SOCKET_PORT := strconv.Itoa(48042)

	fmt.Println("Waiting for connection ...")
	connection, _ := net.Dial("tcp", "127.0.0.1:" + SOCKET_PORT)
	fmt.Println("Connection established")
	connectionClosed := false
	for !connectionClosed {
		message, _ := bufio.NewReader(connection).ReadString('\n')
		fmt.Println("Message received")
		data := strings.Split(message, " ")

		packetType, _ := strconv.Atoi(data[0])
		data = data[1:]

		//TODO cleanup later
		if packetType == 0 {
			fmt.Println("Hello packet received! Sending one back ...")
			fmt.Fprintf(connection, "0" + "\n")
		} else {
			fmt.Println("Unknown packet received")
		}
	}
}

