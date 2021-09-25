import React from "react";
import { View, StyleSheet } from "react-native";
import { Container, Icon, IconButton, Text, Circle, Center } from "native-base";
import { Entypo } from "@expo/vector-icons";

export default function Checkout() {
    return (
        <View style={{ backgroundColor: '#ED702D', flex: 1 }}>
            <Text color="white" fontSize="xl" fontWeight="bold" padding={10} lineHeight="23">
                Transfering cart. Please proceed on the checkout machine.
            </Text>
            <Center px="3">
                <Circle size={235} bg="#FFFFFF" shadow="2">
                    <Text fontSize="5xl" color="#ED702D" fontWeight="bold">12'025</Text>
                    <Text fontSize="5xl" color="#ED702D" fontWeight="bold">XP</Text>
                </Circle>
            </Center>
            <Center flex={1}>

                <Circle size={30} bg="#FFFFFF">
                    <IconButton
                        icon={<Icon as={Entypo} name="cross" />}
                        borderRadius="full"
                        _icon={{
                            color: "#ED702D",
                            size: "md",
                        }}
                        onPress={() => console.log("Close Checkout")}
                    />
                </Circle>
            </Center>
        </View>

    );
}