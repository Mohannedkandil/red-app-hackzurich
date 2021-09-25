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
                    style={{ height: 400, width: 400 }} />
            </View>
            <Text style={styles.maintext}>{text}</Text>

            {scanned && <Button colorScheme="success" width={40} onPress={() => setScanned(false)} >
                <Text style={{ color: "white", fontWeight: 'bold' }}>Scan Again?</Text>
            </Button>}
            <Box
                bg="#FFFFFF"
                rounded="lg"
                height="350px"
                width="350px"
                borderColor="#FFFFFF"
                borderWidth="10"
            >
                <ScrollView
                    alignSelf="center"
                    _contentContainerStyle={{
                        px: "50px",
                        mb: "4",
                    }}>
                    <Stack space={3} alignItems="center">
                        <HStack space={3}>
                            <Circle size={5} bg="white" borderWidth="0.25" borderColor="#ED702D">
                                <Text>1</Text>
                            </Circle>
                            <Text style={styles.productInfo}>Product Name</Text>
                            <Text style={styles.productInfo}>3.50</Text>
                        </HStack>
                        <VStack space={1} marginBottom={20}>
                            <Text>CHF 3.50</Text>
                        </VStack>
                    </Stack>

                </ScrollView>
            </Box>
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
        height: 300,
        width: 300,
        overflow: 'hidden',
        borderRadius: 30,
        backgroundColor: 'tomato'
    },
    productInfo: {
        fontSize: 14,
        fontWeight: "bold"
    }
});