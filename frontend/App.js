import React from "react";
import {NativeBaseProvider} from "native-base";
import {NavigationContainer} from "@react-navigation/native";
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import Home from "./screens/Home";
import Profile from "./screens/Profile";
import ScanProduct from "./screens/ScanProduct";

const Stack = createNativeStackNavigator();

export default function App() {
    return (
        <NativeBaseProvider>
            <NavigationContainer>
                <Stack.Navigator initialRouteName="Home" screenOptions={{headerShown: false}}>
                    <Stack.Screen name="Home" component={Home}/>
                    <Stack.Screen name="Profile" component={Profile}/>
                    <Stack.Screen name="ScanProduct" component={ScanProduct}/>
                </Stack.Navigator>
            </NavigationContainer>
        </NativeBaseProvider>
    );
}
