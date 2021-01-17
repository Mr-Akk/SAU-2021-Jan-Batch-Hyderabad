import React from "react";
import { StyleSheet, TouchableOpacity, Text } from "react-native";

const Button = ({ item, handleButtonClick }) => {
  return (
    <TouchableOpacity
      onPress={() => handleButtonClick(item)}
      style={styles.appButtonContainer}
    >
      <Text style={styles.appButtonText}>{item}</Text>
    </TouchableOpacity>
  );
};

export default Button;

const styles = StyleSheet.create({
  appButtonContainer: {
    elevation: 8,
    backgroundColor: "black",
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 12,
    marginBottom: 3,
    borderWidth: 2,
    borderColor: "#FED343",
  },
  appButtonText: {
    fontSize: 18,
    color: "#fff",
    fontWeight: "bold",
    alignSelf: "center",
    textTransform: "uppercase",
  },
});
