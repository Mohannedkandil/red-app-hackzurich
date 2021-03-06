import React from "react";
import { NativeBaseProvider } from "native-base";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Home from "./screens/Home";
import Profile from "./screens/Profile";
import ScanProduct from "./screens/ScanProduct";
import Checkout from './screens/Checkout';
import CheckIn from './screens/CheckIn';
import WeeklyChallenge from "./screens/WeeklyChallenge";
import Challenges from "./screens/Challenges";

const Stack = createNativeStackNavigator();

export default function App() {
    return (
        <NativeBaseProvider>
            <NavigationContainer>
                <Stack.Navigator initialRouteName="Home" screenOptions={{ headerShown: false }}>
                    <Stack.Screen name="Home" component={Home} />
                    <Stack.Screen name="Profile" component={Profile} />
                    <Stack.Screen name="ScanProduct" component={ScanProduct} />
                    <Stack.Screen name="Checkout" component={Checkout} />
                    <Stack.Screen name="CheckIn" component={CheckIn} />
                    <Stack.Screen name="WeeklyChallenge" component={WeeklyChallenge} />
                    <Stack.Screen name="Challenges" component={Challenges}/>
                </Stack.Navigator>
            </NavigationContainer>
        </NativeBaseProvider>
    );
}
