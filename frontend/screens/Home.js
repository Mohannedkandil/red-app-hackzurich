import React from "react";
import { Container, Icon, IconButton, Text } from "native-base";
import { Entypo } from "@expo/vector-icons";

export default function Home({ navigation }) {
    return (
        <Container>
            <Text>Screen Mockup</Text>
            <IconButton
                icon={<Icon as={Entypo} name="camera" />}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("ScanProduct")}
            />
            <IconButton
                icon={<Icon as={Entypo} name="user" />}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("Profile")}
            />
            <IconButton
                icon={<Icon as={Entypo} name="shop" />}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("Checkout")}
            />
            <IconButton
                icon={<Icon as={Entypo} name="store" />}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("CheckIn")}
            />
            <IconButton
                icon={<Icon as={Entypo} name="calendar" />}
                borderRadius="full"
                _icon={{
                    color: "orange.500",
                    size: "md",
                }}
                onPress={() => navigation.navigate("WeeklyChallenge")}
            />
        </Container>
    );
}
