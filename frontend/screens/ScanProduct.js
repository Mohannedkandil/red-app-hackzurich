import React, {useEffect, useState} from 'react';
import {ImageBackground, StyleSheet, View} from 'react-native';
import {BarCodeScanner} from 'expo-barcode-scanner';
import {Box, Button, Center, HStack, Image, Pressable, ScrollView, Text, VStack,} from "native-base"

export default function App({navigation}) {
    const [hasPermission, setHasPermission] = useState(null);
    const [scanned, setScanned] = useState(false);
    const [text, setText] = useState('Not yet scanned');
    const [cart, setCart] = useState([]);

    const askForCameraPermission = () => {
        (async () => {
            const {status} = await BarCodeScanner.requestPermissionsAsync();
            setHasPermission(status === 'granted');
        })()
    }

    // Request Camera Permission
    useEffect(() => {
        askForCameraPermission();
    }, []);

    // What happens when we scan the bar code
    const handleBarCodeScanned = ({type, data}) => {
        setScanned(true);
        setText(data)

        // TODO: Get details from API
        const existingProduct = cart.find(x => x.id === data);
        if (existingProduct) {
            setCart(cart.concat({...existingProduct, amount: existingProduct.amount + 1}));
        } else {
            setCart(cart.concat({id: 42, name: "M-Classic Crunchy Erdnussbutter", amount: 1, price: 3.50, hasMCheck: true}));
        }
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
                <Text style={{margin: 10}}>No access to camera</Text>
                <Button colorScheme="primary" width={40} onPress={() => askForCameraPermission()}>
                    <Text style={{color: "white", fontWeight: 'bold'}}>Allow Camera</Text>
                </Button>
            </View>)
    }
    if (scanned === true && text === "Bio V-Love Pesto") {
        navigation.navigate("WeeklyChallenge");

    }

    // Return the View
    return (
        <View style={styles.container}>
            <ImageBackground source={require('../assets/background.png')} style={{flex: 1, resizeMode: 'cover', justifyContent: 'center'}}>
                <Center>
                    <View style={styles.barcodebox}>
                        <BarCodeScanner
                            onBarCodeScanned={scanned ? undefined : handleBarCodeScanned}
                            style={{height: 250, width: 350}}/>
                    </View>

                    <HStack>
                        {
                            scanned && <Button bg="#ED702D" onPress={() => setScanned(false)} mt="20px" mr="10px">
                                <Text style={{color: "white", fontWeight: 'bold', paddingRight: 10, paddingLeft: 10}}>Scan Again</Text>
                            </Button>
                        }
                        {
                            scanned && <Button colorScheme="success" onPress={() => navigation.navigate("Checkout")} mt="20px" ml="10px">
                                <Text style={{color: "white", fontWeight: 'bold', paddingRight: 10, paddingLeft: 10}}>Checkout</Text>
                            </Button>
                        }
                    </HStack>

                    <Box bg="#FFFFFF" rounded="10px" height="325px" width="350" mt="20px" padding="10px">
                        <ScrollView>
                            {cart.map((x, index) =>
                                <HStack key={index} justifyContent="space-between" mb="10px">
                                    <Center><Text textAlign="center" bold>{x.amount}</Text></Center>
                                    <VStack key={index}>
                                        <HStack >
                                            <Text>{x.name}</Text>
                                        </HStack>
                                        <HStack justifyContent="space-between">
                                            <Text>{x.price} CHF</Text>
                                            {x.hasMCheck && <Text bold color="#009933">M-CHECK</Text>}
                                        </HStack>
                                    </VStack>
                                    <Text>{x.amount * x.price}</Text>
                                </HStack>
                            )}
                        </ScrollView>
                    </Box>
                    <Pressable onPress={() => navigation.navigate("Home")} mt="15px">
                        <Image size="55px" source={require('../assets/menu/icon-close.png')} alt="Back to home screen"/>
                    </Pressable>
                </Center>
            </ImageBackground>
        </View>


    );
}

const styles = StyleSheet.create({
    safeAreaView: {
        height: 350
    },
    container: {
        flex: 1,
    },
    maintext: {
        fontSize: 25,
        margin: 20,
    },
    barcodebox: {
        alignItems: 'center',
        justifyContent: 'center',
        height: 250,
        width: 350,
        overflow: 'hidden',
        borderRadius: 30,
        backgroundColor: 'tomato',
        marginTop: 40,
    },
    productInfo: {
        fontSize: 14,
        fontWeight: "bold"
    }
});
