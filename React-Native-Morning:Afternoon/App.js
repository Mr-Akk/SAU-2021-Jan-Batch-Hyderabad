import React from "react";
import "react-native-gesture-handler";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";

import MovieDetailComponent from "./Components/MovieDetailComponent/MovieDetailComponent";
import HomeComponent from "./Components/Home/HomeComponent";

const Stack = createStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen name="Home" component={HomeComponent} />
        <Stack.Screen name="MovieDetail" component={MovieDetailComponent} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
