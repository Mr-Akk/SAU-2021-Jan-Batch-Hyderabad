import React from "react";
import {
  View,
  TouchableOpacity,
  Image,
  Text,
  StyleSheet,
  ScrollView,
} from "react-native";

const MovieDetailComponent = ({ route }) => {
  let {
    title,
    vote_average,
    popularity,
    original_language,
    release_date,
    overview,
    imagepath,
  } = route.params.item;

  return (
    <View style={styles.container}>
      <TouchableOpacity style={styles.innerContainer}>
        <Image
          style={styles.movieImage}
          source={{
            uri: imagepath,
          }}
        />
      </TouchableOpacity>
      <View style={styles.movieView}>
        <ScrollView>
          <Text style={styles.movieText}>{title}</Text>
          <Text style={styles.movieInnerText}>
            Vote Average : {vote_average}
          </Text>
          <Text style={styles.movieInnerText}>Popularity : {popularity} </Text>
          <Text style={styles.movieInnerText}>
            Original Language : {original_language}
          </Text>
          <Text style={styles.movieInnerText}>
            Release Date : {release_date}
          </Text>
          <Text style={styles.movieInnerText}>Overview : {overview} </Text>
        </ScrollView>
      </View>
    </View>
  );
};

export default MovieDetailComponent;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: "center",
  },
  innerContainer: {
    flex: 1,
    width: "100%",
    height: "100%",
    alignItems: "center",
    justifyContent: "center",
    marginTop: 20,
  },
  movieImage: {
    flex: 1,
    width: "90%",
    height: "100%",
    borderWidth: 3,
    borderColor: "#FED343",
  },
  movieView: {
    flex: 1,
    width: "90%",
  },
  movieText: {
    fontSize: 30,
    letterSpacing: 3,
    textAlign: "center",
  },
  movieInnerText: {
    fontSize: 18,
    padding: 7,
    borderBottomWidth: 2,
    borderColor: "#F5E1AF",
  },
});
