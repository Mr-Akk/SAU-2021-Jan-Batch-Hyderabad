import React, { Component } from "react";
import axios from "axios";

import { StyleSheet, View, ScrollView, FlatList } from "react-native";

import MovieList from "../MovieList/MovieList";
import Spinner from "../Shared/Spinner/Spinner";
import Button from "../Shared/Button/Button";

export default class HomeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      toprated: [],
      popular: [],
      upcoming: [],
      items_to_display: [],
      buttonContent: ["popular", "toprated", "upcoming"],
    };
  }

  handleMovieListClick = (item) => {
    this.props.navigation.navigate("MovieDetail", { item: item });
  };

  handleButtonClick = (text) => {
    this.setState({
      items_to_display: this.state[text],
    });
  };

  componentDidMount() {
    let imageUrl = "https://image.tmdb.org/t/p/original";
    axios
      .get(
        "https://api.themoviedb.org/3/movie/popular?api_key=046c172c2278333d2373298a8a940835&language=en-US&page=1"
      )
      .then((res) => {
        let newArr = res.data.results.map((i) => {
          return {
            ...i,
            imagepath: imageUrl + i.poster_path,
          };
        });
        this.setState({
          popular: newArr,
          items_to_display: newArr,
        });
      });

    axios
      .get(
        "https://api.themoviedb.org/3/movie/top_rated?api_key=046c172c2278333d2373298a8a940835&language=en-US&page=1"
      )
      .then((res) => {
        let newArr = res.data.results.map((i) => {
          return {
            ...i,
            imagepath: imageUrl + i.poster_path,
          };
        });
        this.setState({
          toprated: newArr,
        });
      });

    axios
      .get(
        "https://api.themoviedb.org/3/movie/upcoming?api_key=046c172c2278333d2373298a8a940835&language=en-US&page=1"
      )
      .then((res) => {
        let newArr = res.data.results.map((i) => {
          return {
            ...i,
            imagepath: imageUrl + i.poster_path,
          };
        });
        this.setState({
          upcoming: newArr,
        });
      });
  }

  render() {
    let displayContent = <Spinner />;

    if (this.state.popular.length > 0) {
      displayContent = (
        <View style={styles.container}>
          <ScrollView
            style={{
              margin: 20,
            }}
          >
            <FlatList
              data={this.state.items_to_display}
              renderItem={({ item, index }) => {
                return (
                  <MovieList
                    item={item}
                    handleMovieListClick={this.handleMovieListClick}
                  />
                );
              }}
            />
          </ScrollView>
          <View style={styles.placeBottom}>
            {this.state.buttonContent.map((i) => (
              <Button item={i} handleButtonClick={this.handleButtonClick} />
            ))}
          </View>
        </View>
      );
    }
    return displayContent;
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    marginTop: 40,
  },
  placeBottom: {
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "flex-end",
  },
});
