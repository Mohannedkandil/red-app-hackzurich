import React, { useState, useEffect } from 'react';
import { View, StyleSheet, SafeAreaView } from 'react-native';
import { BarCodeScanner } from 'expo-barcode-scanner';
import { LinearGradient } from 'expo-linear-gradient';
import {
    ScrollView,
    Button,
    Box,
    Stack,
    HStack,
    Text,
    Circle,
    VStack,
    Center,
    useTheme,
    Heading,
    NativeBaseProvider,
} from "native-base"

export default function App() {
    const [hasPermission, setHasPermission] = useState(null);
    const [scanned, setScanned] = useState(false);
    const [text, setText] = useState('Not yet scanned')

    const askForCameraPermission = () => {
        (async () => {
            const { status } = await BarCodeScanner.requestPermissionsAsync();
            setHasPermission(status === 'granted');
        })()
    }

    // Request Camera Permission
    useEffect(() => {
        askForCameraPermission();
    }, []);

    // What happens when we scan the bar code
    const handleBarCodeScanned = ({ type, data }) => {
        setScanned(true);
        setText(data)
        console.log('Type: ' + type + '\nData: ' + data)
    };

    // Check permissions and return the screens
    if (hasPermission === null) {
        return (
            <View style={styles.container}>
                <Text>Requesting for camera permission</Text>
            </View>)
    }
    if (hasPermission === false) {
        return (
            <View style={styles.container}>
                <Text style={{ margin: 10 }}>No access to camera</Text>
                <Button colorScheme="primary" width={40} onPress={() => askForCameraPermission()}>
                    <Text style={{ color: "white", fontWeight: 'bold' }}>Allow Camera</Text>
                </Button>
            </View>)
    }

    // Return the View
    return (
        <View style={styles.container}>
            <View style={styles.barcodebox}>
                <BarCodeScanner
                    onBarCodeScanned={scanned ? undefined : handleBarCodeScanned}
                    style={{ height: 490, width: 368 }} />
            </View>
            <Text style={styles.maintext}>{text}</Text>

            {scanned && <Button colorScheme="success" width={40} onPress={() => setScanned(false)} >
                <Text style={{ color: "white", fontWeight: 'bold' }}>Scan Again?</Text>
            </Button>}

            <Stack space={2} alignItems="center">
                <HStack space={2} alignItems="center">
                    <Button>Profile</Button>
                    <Button>Scanf off</Button>
                </HStack>
            </Stack>

        </View>


    );
}

const styles = StyleSheet.create({
    safeAreaView: {
        height: 350
    },
    container: {
        flex: 1,
        backgroundColor: '#38A3A5',
        alignItems: 'center',
        justifyContent: 'center',
    },
    maintext: {
        fontSize: 25,
        margin: 20,
    },
    barcodebox: {
        alignItems: 'center',
        justifyContent: 'center',
        height: 490,
        width: 368,
        overflow: 'hidden',
        borderRadius: 10,
        backgroundColor: 'tomato'
    },
    productInfo: {
        fontSize: 14,
        fontWeight: "bold"
    }
});