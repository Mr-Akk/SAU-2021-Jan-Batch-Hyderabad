import React from "react";
import { TouchableOpacity, Image, Text, StyleSheet } from "react-native";

const MovieList = ({ item, handleMovieListClick }) => {
  return (
    <TouchableOpacity
      onPress={() => handleMovieListClick(item)}
      style={styles.card}
    >
      <Image
        style={styles.cardImage}
        source={{
          uri: item.imagepath,
        }}
      />
      <Text style={styles.cardText}>{item.title}</Text>
    </TouchableOpacity>
  );
};

export default MovieList;

const styles = StyleSheet.create({
  card: {
    marginBottom: 20,
    marginLeft: 10,
    width: "90%",
    shadowColor: "#000",
    shadowOpacity: 1,
    borderWidth: 2,
    borderColor: "#FED343",
    shadowOffset: {
      width: 3,
      height: 3,
    },
  },
  cardImage: {
    flex: 1,
    width: "100%",
    height: 400,
    resizeMode: "cover",
  },
  cardText: {
    fontSize: 20,
    padding: 20,
    letterSpacing: 2,
    fontStyle: "italic",
  },
});
